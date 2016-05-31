package bazhanau.logprocessor

import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.{IntWritable, Text}
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat

/**
  * Created by a.bazhanau on 31.05.16.
  */
object JobBootstrapper{
  def main(args: Array[String]) {
    val job = new Job()
    job.setJarByClass(this.getClass)
    job.setJobName("IP counter")

    FileInputFormat.addInputPath(job, new Path(args(0)))
    FileOutputFormat.setOutputPath(job, new Path(args(1)))

    job.setMapperClass(classOf[IPMapper])
    job.setReducerClass(classOf[Counter])

    job.setMapOutputKeyClass(classOf[Text]);
    job.setMapOutputValueClass(classOf[IntWritable]);

    job.setOutputKeyClass(classOf[Text])
    job.setOutputValueClass(classOf[IntWritable])

    job.waitForCompletion(true)
  }
}
