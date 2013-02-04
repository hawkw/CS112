$number = 0;

open(RESULT, ">result.csv");
select((select (RESULT),$= = 57)[0]);

#runs for each element in this list
foreach $number (1,5,10,15,20,25,30,35,40,45) {
		foreach $algorithm ("recursive", "iterative") {
			foreach $type ("int", "long"){
				foreach $numbertwo (1 ... 5) {
					open(TEST, "java -cp \"profiler.jar:.\" UseFibonacci $number $algorithm $type|");
                    #read from the test command
                    $input = "";
                    while(<TEST>) {
                        chop;
                        $input = $input . $_;
                    }
                    close(TEST);
                    $input =~ /average = (\d+\.\d+)/;
                    $input = $1;
                    write RESULT;
                    print "testing UseFibonacci $number $algorithm $type, time = $input \n";
			}
		}
	}
}

format top =
INPUT,ALGORITHM,TYPE,TIME(ms)
.

format RESULT =
@##,@||||||||||,@||||,@#####.##
$number,$algorithm,$type,$input
.