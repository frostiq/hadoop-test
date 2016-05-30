## Copy Input File into HDFS
	
	hadoop fs -copyFromLocal input/sample-median.txt /user/hduser/input/sample-median.txt

## Execute the MapReduce Job
	
	hadoop jar hadoop-median-example.jar com.hadoop.example.MedianTemperature  /user/hduser/input/sample-median.txt  /user/hduser/output
  
## Copy Output to Local File System  

	hadoop fs -copyToLocal /user/hduser/output output
	
	
## Output from the MapReduce Task
   
    cat output/median/part-r-00000 
   
  
