temp=125667

reve=$(echo $temp | rev)
echo $reve

if [ $temp -eq $reve ];
then
    echo "Number is palindrome"
else
    echo "Number is NOT palindrome"
fi
