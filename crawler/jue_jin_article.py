import requests
import re
import pymysql


def get_detail_content(article_id):
    """
    爬取掘金文章内容
    :param article_id: 文章ID
    :return: 文章内容字符串
    """

    url = "https://juejin.cn/post/" + article_id

    headers = {
        "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
    }

    resp = requests.get(url, headers=headers)

    text = resp.text

    resp.close()

    li = re.findall(r'article_info:{.*display_count:.*?}', text)

    s = "7016520448204603423"  # 如果没有该文章id对应的数据就用这个
    if len(li) > 0:
        s = li[0]

    # 查找开始位置
    start_idx = s.find("mark_content")

    start_idx = start_idx + 14

    # 查找结束位置
    end_idx = s.find("display_count")

    end_idx = end_idx - 2

    result = s[start_idx:end_idx]

    return result


# test

# aid = "7130812569043861511"
#
# print(get_detail_content(aid))

# 连接数据库
host = "....."
port = 3306
user = "...."
password = "....."
charset = "utf8mb4"
db = "jue_jin"
# 返回连接对象
conn = pymysql.connect(host=host, port=port, user=user, password=password, charset=charset, db=db)
# 创建操作对象
cur = conn.cursor()
# 执行sql语句查出所有文章id记录
sql = "select article_id from article_info"
cur.execute(sql)
# 返回执行结果
tup = cur.fetchall()

for ele in tup:
    article_id = ele[0]
    # 根据id查询文章内容
    article_content = get_detail_content(article_id=article_id)
    sql = "insert into article_content(article_id,mark_content) values(%s,%s)"
    cur.execute(sql, (article_id, article_content))
    conn.commit()

print("finish")

# 释放资源
cur.close()
conn.close()
