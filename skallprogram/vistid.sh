#!/bin/bash

FILE=$1

if [ ! -f $FILE ]; then
   echo "Filen finnes ikke"
   exit 0
fi

echo "Hva er hendelsen?"
read hendelse

regexp="$hendelse."

hendelser=$(cut -f 1-2  $FILE)

declare -i sum=0

cat $FILE | (while read line
   do
      if [[ $line =~ $regexp ]]
      then
         ((sum+=$(echo "$line" | cut -f2)))
      fi
   done
   echo "$sum"
)

