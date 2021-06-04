#!/bin/bash
Cyan='\033[1;36m'
LG='\033[1;37m' #light grey
Green='\033[1;32m'
NC='\033[0m' # No Color

printf "$Cyan\n***** WELCOME TO MINESWEEPER BUILD AND REGRESSION TESTING SCRIPT *****\n"

printf "\n$LG This script will use Gradle to build the Minesweeper project and run the test suite, and then email the build and test results.\n"

printf "\nPlease enter email address:  "

read -r email

printf "$LG\n\nResults will be emailed to: $Green $email \n"

printf "$Cyan\nINITIALIZING BUILD"

printf "$LG\nNow moving to directory of project files...\n"
cd /Users/alisawallace/Dropbox/school/_2021_spring/cpsc5210/project/MineSweeper-main

printf "$LG\nInitializing Gradle Wrapper to build project...\n\n $NC"
build_output="$(mktemp)"
./gradlew | tee $build_output
build_output_trunc="$(mktemp)"
tail -2 $build_output > $build_output_trunc
# cat $build_output_trunc

printf "$Cyan\n\nEMAILING BUILD RESULTS\n $NC"
cp $build_output_trunc build/reports/build_output.txt

cd /Users/alisawallace/Dropbox/school/_2021_spring/cpsc5210/project/MineSweeper-main/build/reports/

mutt -s "Minesweeper: Project Build Results" $email < build_output.txt

printf "$LG\nBuild results emailed to $Green $email \n"

cd /Users/alisawallace/Dropbox/school/_2021_spring/cpsc5210/project/MineSweeper-main

printf "$Cyan\nRUNNING TEST SUITE\n $NC"
output_file="$(mktemp)"
./gradlew test --stacktrace | tee $output_file

cd /Users/alisawallace/Dropbox/school/_2021_spring/cpsc5210/project/MineSweeper-main/build/reports/tests/

printf "$Cyan\n\nEMAILING TEST RESULTS\n"
cp $output_file test/test_output.txt
mutt -e 'set content_type=text/html'  -s 'Minesweeper: Test Suite Results' -a test/test_output.txt -- $email < test/index.html

printf "$LG\nTest results emailed to $Green $email \n"

printf "$Cyan\nPROCESS COMPLETE.  GOODBYE!\n"