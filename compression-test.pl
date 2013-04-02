$number = 0;

open(RESULT, ">result.csv");
select((select (RESULT),$= = 57)[0]);

#runs for each element in this list
    foreach $algorithm ("pack200", "pack200 --no-gzip") {
        foreach $jarfile ("profiler.jar", "twitter4j.jar"){
            foreach $try (1 ... 5) {
                open(TEST, "/usr/bin/time $algorithm $jarfile|");
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

format top =
INPUT,ALGORITHM,TYPE,TIME(ms)
.

format RESULT =
@##,@||||||||||,@||||,@#####.##
$number,$algorithm,$type,$input
.