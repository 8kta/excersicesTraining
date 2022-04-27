import ipaddress
import sys

ip = '168.182.2.64'

try:
    ip = ipaddress.ip_address(ip)
    print('%s is a correct IP%s address.' % (ip, ip.version))
except ValueError:
    print('address/netmask is invalid: %s' % ip)
