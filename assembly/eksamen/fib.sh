#!/bin/bash

a=1
b=2

for i in `seq 1 $1`
do
   echo $a
   t=$a
   a=$b
   b=$(expr $t + $b)
done
