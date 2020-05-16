
## Logs Parser to Parse Access Logs in Scala

```
193.238.97.109 - - [23/Jun/2017:13:38:51 -0500] "GET /wp-admin HTTP/1.0" 200 4981 "http://www.thomas.com/" "Mozilla/5.0 (X11; Linux i686) AppleWebKit/5322 (KHTML, like Gecko) Chrome/13.0.859.0 Safari/5322"
131.82.131.16 - - [23/Jun/2017:13:38:51 -0500] "GET /app/main/posts HTTP/1.0" 500 4961 "http://www.smith-drake.info/search.php" "Mozilla/5.0 (Macintosh; PPC Mac OS X 10_6_9) AppleWebKit/5330 (KHTML, like Gecko) Chrome/15.0.882.0 Safari/5330"
114.108.208.224 - - [23/Jun/2017:13:38:51 -0500] "PUT /posts/posts/explore HTTP/1.0" 200 4955 "http://holt.org/author.html" "Mozilla/5.0 (Macintosh; PPC Mac OS X 10_6_7; rv:1.9.6.20) Gecko/2015-10-10 23:39:38 Firefox/3.8"
191.49.132.63 - - [23/Jun/2017:13:38:51 -0500] "GET /wp-admin HTTP/1.0" 503 4948 "http://huang.com/category.html" "Mozilla/5.0 (Macintosh; PPC Mac OS X 10_8_4; rv:1.9.5.20) Gecko/2014-05-04 14:45:38 Firefox/3.8"
32.37.41.14 - - [23/Jun/2017:13:38:51 -0500] "POST /search/tag/list HTTP/1.0" 200 4983 "http://andrews-alvarez.org/category.htm" "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/5351 (KHTML, like Gecko) Chrome/14.0.823.0 Safari/5351"
89.64.76.98 - - [23/Jun/2017:13:38:51 -0500] "GET /posts/posts/explore HTTP/1.0" 200 5045 "http://deleon.info/main.php" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_7; rv:1.9.2.20) Gecko/2015-11-01 02:37:00 Firefox/14.0"
97.63.130.73 - - [23/Jun/2017:13:38:51 -0500] "DELETE /apps/cart.jsp?appID=7978 HTTP/1.0" 403 4902 "http://pitts-jackson.com/home/" "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/5320 (KHTML, like Gecko) Chrome/13.0.817.0 Safari/5320"
    
```

## Main Application

```ParserMainExample``` has the sample implementation


You can directly read from file if needed instead of reading from the class itself

## Check below Blog for Access Logs Details

[Access Logs Format ](https://www.nitendratech.com/technology/access-logs-format/)


