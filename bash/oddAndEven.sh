#Given an array say if the number is odd or even

clasification (){
  local arrayGiven=$1
  for i in "${arrayGiven[*]}"
  do
    ((i%2)) && echo odd || echo even
  done
}


#array=()
read -a numbers

clasification $numbers
