TIME=$1
FILE=$2
RUNNING=1
MD5="0"

if [ -f $FILE ]; then
	MD5=$(md5sum $FILE)
fi

while [ $RUNNING -eq 1 ];
do
	sleep $TIME
	#Checking if file has been created
	if [ "$MD5" = "0" ]; then
		if [ -f $FILE ]; then
			echo "Filen $FILE ble opprettet."
		fi
	#File exists, doing checks of editing and deletion here
	#Checking if file has been deleted
	if [ ! -f $FILE ]; then
		echo "Filen $FILE ble slettet."
		continue;
	fi
	#Checking if file has been edited
	if [[ $(md5sum $FILE) != $MD5 ]]; then
		echo "Filen $FILE ble endret."
		RUNNING=0;
	fi
fi
done
exit 0
