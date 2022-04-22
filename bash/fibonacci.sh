fibonacci() {
a=1
b=1
local number=$1
for (( i=0; i<$number; i++ ))
do
    echo $a
    nthTerm=$((a + b))
    a=$b
    b=$nthTerm
done
}

echo Enter a number
read number
echo Fibonacci sequence: $(fibonacci $number)
