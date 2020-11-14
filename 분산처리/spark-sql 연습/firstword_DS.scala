val textFile = sc.textFile("./README.txt")

val firstword = textFile.flatMap(_.split(" ")).map(_.replaceAll( "[^a-zA-Z\\d]", "").trim.toLowerCase).filter(!_.isEmpty)

val firstwordDF = firstword.toDF()

case class Id(value:String)

val firstwordDS = firstwordDF.as[Id]

firstwordDS.show()

firstwordDS.createOrReplaceTempView("id")

spark.sql("select count(*) from id group by(substring(value,0,1))").show()


