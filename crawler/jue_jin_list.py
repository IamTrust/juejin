import json

import pandas as pd
import xlwt
import requests


# 处理结果
# 拿到一个list，list里面每个元素是一个dict字典，字典里的article_info里的数据就是需要的
def get_article_info(json_data_list):
    result_list = []
    for dit in json_data_list:
        _dit = dit["item_info"]

        # # article_info
        # if "article_info" in _dit:
        #     result_list.append(_dit["article_info"])
        # # author_user_info

        if "author_user_info" in _dit:
            result_list.append(_dit["author_user_info"])
        # # tags
        # if "tags" in _dit:
        #     # 取到的是一个数组
        #     temp_list = _dit["tags"]
        #     if len(temp_list) > 0:
        #         result_list.append(temp_list[0])

    return result_list


# 爬数据
def crawler_jue_jin(current_page):
    url = "https://api.juejin.cn/recommend_api/v1/article/recommend_all_feed?aid=2608&uuid=7123759892783040000"

    headers = {
        "content-type": "application/json;charset=utf-8",
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36',
        "origin": "https://juejin.cn",
        "referer": "https://juejin.cn/",
        "cookie": "_ga=GA1.2.1069960429.1658629609; __tea_cookie_tokens_2608=%257B%2522web_id%2522%253A%25227123759892783040000%2522%252C%2522user_unique_id%2522%253A%25227123759892783040000%2522%252C%2522timestamp%2522%253A1658629609298%257D; _tea_utm_cache_6587={%22utm_source%22:%22jjhd_2021_qxybj%22}; _tea_utm_cache_2608={%22utm_source%22:%22gold_browser_extension%22}; MONITOR_WEB_ID=efc1dda2-8e66-4b1a-95c6-039cdd100710; _gid=GA1.2.164141089.1659063255"
    }

    payload = {
        "client_type": 2608,
        "cursor": str(current_page),
        "id_type": 2,
        'limit': 20,
        "sort_type": 200
    }

    resp = requests.post(url=url, data=json.dumps(payload), headers=headers)

    json_data = resp.json()["data"]

    result = get_article_info(json_data)

    resp.close()

    return result


index = 0
data_list = []
while index < 52:
    temp = crawler_jue_jin(index)
    data_list.extend(temp)
    index += 1


# 写文件到excel 或 直接存到数据库
def export_excel(export):
    # 将字典列表转换为DataFrame
    pf = pd.DataFrame(list(export))

    # 生成的excel
    file_path = pd.ExcelWriter("juejin_data_users.xlsx")

    pf.to_excel(file_path, encoding="utf-8", index=False)
    file_path.save()


print("start write data to excel...")
export_excel(data_list)
print("finish!")
