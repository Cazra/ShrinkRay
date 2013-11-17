Shrink Ray

A batch image size reducer. It takes all jpg images in a 
source directory (given as the single argument to the program, or the 
current directory if none is provided), and outputs them to the "/shrinkray" 
output directory with their dimensions reduced by 50%.


Requirements:

Java
Ant


To build:

On command line, run 'ant clean all'.
The jar file for the program will be created at '/latest/shrinkray.jar'


To run:

Assuming that you have a command terminal open in the directory with the 
shrinkray jar file, run 
'java -jar shrinkray.jar [optional image source directory]'

If no source directory is provided as the argument, it will process any jpg
images in the current directory.

