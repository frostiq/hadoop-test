#MapReduce Sample
This sample uses the MapReduce API to find the Median temperature from an Input file

## Sample Input File
	
	1990 21
	1990 20
	1990 24
	1991 23
	1991 24
	1991 26
	1991 27	

## Copy Input File into HDFS
	
	hadoop fs -copyFromLocal ../hadoop-samples/myinput/sample-median.txt /user/hduser/input/sample-median.txt

## Execute the MapReduce Job
	
	hadoop jar ../hadoop-samples/hadoop-median-example.jar com.hadoop.example.MedianTemperature  /user/hduser/input/sample-median.txt  /user/hduser/output/median
  
## Copy Output to Local File System  

	hadoop fs -copyToLocal /user/hduser/output-median output/median
	
	
## Output from the MapReduce Task
   
        $ cat output/median/part-r-00000 
        1990	21
        1991	24
   
  
