#!/bin/bash


declare -i tall=$1

if ($1 < 0)
then
   echo "Feil verdi"
   exit 0
fi


for (( i=0; i < $tall; i++)) 
do
   echo $2
done
