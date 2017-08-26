#!/bin/bash

declare fil=$1

while true;
do
   lesTid= stat -c%x $fil
   echo $lesTid
   sleep 2
   echo "Sov i 2 sek"

done


echo $fil
exit 0
