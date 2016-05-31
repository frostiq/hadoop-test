## Copy Input File into HDFS
	
	hadoop fs -copyFromLocal input/sample.log /user/hduser/input/sample.log

## Execute the MapReduce Job
	
	hadoop jar hadoop-samples.jar bazhanau.logprocessor.JobBootstrapper$ /user/hduser/input/sample.log  /user/hduser/output

  
## Copy Output to Local File System  

	hadoop fs -copyToLocal /user/hduser/output output
	
	
## Output from the MapReduce Task
   
    cat output/median/part-r-00000 
   
  
