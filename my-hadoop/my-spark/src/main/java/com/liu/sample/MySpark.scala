package com.liu.sample

import org.apache.spark.{SparkConf, SparkContext}

object MySpark {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test")
      .setMaster("local[4]")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(1,2,3))

    println("-----------------" + rdd1.reduce(_+_))
  }
}
