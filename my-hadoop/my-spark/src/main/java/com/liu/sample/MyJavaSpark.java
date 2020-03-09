package com.liu.sample;

import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class MyJavaSpark {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        JavaSparkContext sc = new JavaSparkContext("local[4]", "myapp", conf);
        JavaRDD<Integer> rdd = sc.parallelize(Lists.asList(1, new Integer[]{2, 3}));
        long count = rdd.count();
        System.out.println("===========count:" + count);
    }
}
