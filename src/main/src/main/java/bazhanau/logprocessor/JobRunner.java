package bazhanau.logprocessor;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobRunner {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        if (args.length != 2) {
            System.err.println("Usage: MedianTemperature <input path> <output path>");
            System.exit(-1);
        }

        List<Job> jobs = new ArrayList<Job>();
        jobs.add(buildIpCounter("IPCounter 1", args[0], args[1]+"1"));
        jobs.add(buildIpCounter("IPCounter 2", args[0], args[1]+"2"));

        for (Job job : jobs){
            job.waitForCompletion(false);
        }
    }

    private static Job buildIpCounter(String name, String inputPath, String outputPath) throws IOException, InterruptedException, ClassNotFoundException {
        Job job = new Job();
        job.setJarByClass(com.hadoop.example.MedianTemperature.class);
        job.setJobName(name);

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        job.setMapperClass(IPExtractor.class);
        job.setReducerClass(Counter.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.submit();

        return job;
    }
}
