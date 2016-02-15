#!/usr/bin/env python
'''Script to parse Ripple JSON RPC examples and translate them to Java POJOs
for usage in ripple-lj'''
import json
import sys

def main(args):
    if (len(args) < 2):
        print 'Need more args, chief'
        sys.exit(1)

    jsonFilename = args[1]

    print 'Processing ', jsonFilename

    jsonFile = open(jsonFilename, 'r')
    jsonData = json.load(jsonFile)

    print jsonData

if __name__ == '__main__':
    main(sys.argv)
