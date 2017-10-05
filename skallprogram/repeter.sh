#! /bin/bash

declare -i tall=$2

if [[ $tall < 0 ]];
then
   echo "Feil verdi"
   exit 0
fi


for (( i=0; i < $tall; i++)) 
do
   echo $1
done
