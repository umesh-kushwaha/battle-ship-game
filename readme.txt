Steps to run this application:

1. Update the file path in Constants.java file

	public static final String INPUT_FILE_PATH =  "D:\\test\\input.txt";
	
2. I used gradle build tool. You can create jar file by running command "gradle build"

3. I used JUNIT 4 and Mockito for Junit testing


My Algorithm :
1. Read the input file.
2. Create battle field with Map<Cell,Integer>. 
3. Initialize each cell with Zero Value.
4. Get details of ship for both player
5. Update the Map cell value for ship location based on ship type(Q=2,P=1).
6. When any player got hit then decrement cell value by 1.
7. When each and every cell value of map become zero then play will win.