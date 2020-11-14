#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from pyspark.context import SparkContext
from pyspark.conf import SparkConf
sc = SparkContext.getOrCreate(SparkConf())
import re
text_file = sc.textFile("./README.txt")
counts = text_file.flatMap(lambda line: line.split(" ")).map(lambda word: (re.sub("[^a-zA-Z\\d]","",word), 1)).reduceByKey(lambda a, b: a + b)
counts.saveAsTextFile("./output_python")

