#!/bin/bash

declare -i SUM=0
re='^[0-9]+$'

while read -r TALL ; do
   if ! [[ $TALL =~ $re ]]; then
      echo "Error: ikke ett tall" >&2;
      exit 1
   fi

   SUM=$(($SUM + $TALL))

done

echo "Summen av tallene ble: $SUM"
