#!/bin/bash

FILE=$1

if [ ! -f $FILE ]; then
   echo "Filen finnes ikke"
   exit 0
fi

echo "Hva er hendelsen?"
read hendelse

hendelser=$(cut -f 1 $FILE)

for h in $hendelser
do
   if [ "$hendelse" = "$h" ]; then
     echo "Hei"
   fi

done
