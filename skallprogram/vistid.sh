#!/bin/bash

FILE=$1

if [ ! -f $FILE ]; then
   echo "Filen finnes ikke"
   exit 0
fi

while read line; do
   echo "$line"
done < $FILE
