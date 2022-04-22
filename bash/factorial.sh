factorial() {
  local input=$1
  if [[ $input = 0 ]]
  then
    echo 1
  else
    echo $(( input * $(factorial $((input-1))) ))
  fi
}

echo Enter a number
read number
echo Factorial: $(factorial $number)
