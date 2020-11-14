#!/usr/bin/env python
# coding: utf-8

# In[3]:


from pyspark.context import SparkContext


# In[4]:


from pyspark.conf import SparkConf


# In[5]:


sc = SparkContext.getOrCreate(SparkConf())


# In[6]:


text_file = sc.textFile("./README.txt")


# In[7]:


counts = text_file.flatMap(lambda line: line.split(" ")).map(lambda word: (re.sub("[^a-zA-Z\\d]","", word[0]).lower(), 1)).reduceByKey(lambda a, b: a + b)


# In[ ]:


counts.saveAsTextFile("./output_python")

