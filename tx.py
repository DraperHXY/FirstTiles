import requests


# auth = 'q-sign-algorithm=sha1&q-ak=AKIDU0LSZV7LtCUXLsrVdXDqFUSDseOu5BnA&q-sign-time=1547213420;1547217020&q-key-time=1547213420;1547217020&q-header-list=&q-url-param-list=&q-signature=df42fef374c0773b82c636a7f43ab99fbaf83e5a'


def get(url, headers):
    host = 'https://draperstudio-1257985326.cos.ap-beijing.myqcloud.com/'
    host = host + url
    r = requests.get(host, headers=headers)
    return r


def put(url, data):
    host = 'https://draperstudio.oss-cn-zhangjiakou.aliyuncs.com/'
    host = host + url
    headers = {'content-type': 'image/jpeg'}
    r = requests.put(host, data=data)
    return r


r = get("/", None)
# p = put('/img/download.jpg', r.headers.get("Content-Length"), r.headers.get('Content-Type'), r.content)

print(r.content.__len__())
print(r.headers.get("Content-Type"))
print(r.text)

file = open("imgs.xml", 'w')
file.write(r.text)
file.close()

# print(r.headers.get(""))
# print(p)
# print(p.text)


from xml.dom.minidom import parse
import xml.dom.minidom

# 使用minidom解析器打开 XML 文档
DOMTree = xml.dom.minidom.parse("imgs.xml")
collection = DOMTree.documentElement
if collection.hasAttribute("shelf"):
    print("Root element : %s" % collection.getAttribute("shelf"))

# 在集合中获取所有电影
contents = collection.getElementsByTagName("Contents")

keyset = ()


def str2tuple(*str):
    return str


# 打印每部电影的详细信息
for content in contents:
    print("*****Content*****")

    # if movie.hasAttribute("title"):
    #     print("Title: %s" % movie.getAttribute("title"))

    key = content.getElementsByTagName('Key')[0]
    fileName = key.childNodes[0].data
    keyset = keyset + str2tuple(fileName)
    print("Key: %s" % key.childNodes[0].data)

print(keyset)

keylist = list(keyset)

keylist = keylist[1:]

print(keylist)

for key in keylist:
    headers = {'content-type': 'image/jpeg;charset=utf-8'}

    r = get(key, headers=headers)
    print(key)
    print(r.encoding)
    # print(r.text)
    p = put(key, r.content)
    # print(p.status_code)
