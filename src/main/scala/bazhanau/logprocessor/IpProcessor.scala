package bazhanau.logprocessor

import java.lang.Iterable

import scala.collection.JavaConverters._

import org.apache.hadoop.io.{IntWritable, LongWritable, Text}
import org.apache.hadoop.mapreduce.{Mapper, Reducer}


/**
  * Created by a.bazhanau on 31.05.16.
  */
class IPMapper extends Mapper[Text, Text, Text, IntWritable] {
  def regex = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$".r
  def one = new IntWritable(1)

  def map(key: Text, value: Text, context: Context): Unit = {
    val ip = regex.findFirstIn(value.toString)
    context.write(new Text(ip.getOrElse("")), one)
  }
}

class Counter extends Reducer[Text, IntWritable, Text, IntWritable] {
  def reduce(key: Text, values: Iterable[IntWritable], context: Context): Unit = {
    val _values = values.asScala.toSeq
    val sum = _values.map(_.get()).sum
    context.write(key, new IntWritable(sum))
  }
}
