# Response Header Analysis
Response Analysis Tool build in java to help you check the response header for missing headers to avoid security issue .

## Futures 

1 . Detect most important headers if that header missing or not . 

2 . Detect if there is misconfiguration in response header which could lead to CORS attack or XSS or Man in middle attack etc.

3 . allows you to add multi headers requests in single file with custom separator

4 . easy output format


## USING

1 . Run without args ``` ./javac ResAyMain.java ``` to print out help message

2 . Run with 1 arg ``` ./javac ResAyMain.java response_headers.txt ``` to Analysis all response header in response_headers.txt file

3 . Run with 2 args ```./javac ResAyMain.java response_headers.txt HTTP ``` where the HTTP consider as separator between each response in file you can change HTTP as separator to any text or symbol [OPTIONAL]


## Future not added yet 

1 . Add colors to output text

2 . Add Http request with multi thread to fetch the response header from URLs without need to copy the header into text file


