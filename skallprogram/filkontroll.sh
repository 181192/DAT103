#! /bin/bash

if [ -a $1 ];
then
   #While løkke for å monitorere
   GMLFIL=$(stat $1 -c%Y)

   while true
   do
      sleep $2
      #Sjekk om filen er slettet
      if [ ! -f $1 ];
      then
         echo "Filen $1 er slettet"
         exit 0
      else
         #Sjekk om filen er blitt endret
         NYFIL=$(stat $1 -c%Y)
         if [[ $GMLFIL != $NYFIL ]];
            then echo "Filen $1 er endret siden forrige kontroll"
            exit 0
         fi
      fi
   done
else
   #While løkke for å sjekk om filen blir opprettet exit 0
   while [ ! -f $1 ];
   do
      sleep $2
   done
fi
echo "Filen $1 er opprettet"

