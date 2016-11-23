sessionInfo()

install.packages("KoNLP")
install.packages("plyr")
library(KoNLP)
library(plyr)

#����������� 
useSejongDic()

#Test
strLine <- '"��ź �������б��� �����б��� �Ź� 3������鰰�� ������༭ ���� �ٽô���ź�´� �����̿��� �̷� �����ȳ��� ���ִ� �����԰��;�� �ֳĸ� ������� ���ְŵ�� �׷��� ���ִ°� �԰��;�� ���⼭ �ִ� ������"'
schoolList <- read.delim("all_school_name.txt", fileEncoding = "UTF-8", sep="\t")

#�б������� �߰�
mergeUserDic(schoolList)
extractNoun(strLine)
MorphAnalyzer(strLine)
SimplePos22(strLine)

#comment ������(workspace�� csv���� �����س����� )
csvFile <- readLines("comments.csv", encoding = "UTF-8")
zz <- textConnection(csvFile)
commentData <- read.csv(zz,header=F,quote="\"") # give text input
close(zz)

commentData[1366,1]

#�÷��� ���� 
names(commentData)[1] <- c("message")

commentData$message[1:5]
naming.table <- function(sentences, paramTable) {
  DT <- data.table(name="", cnt=0)
  for(line in sentences) {
    laply(extractNoun(as.character(line)), function(c) {
      #x in extractNoun(as.character(line))
      findWord <- paramTable[(paramTable$name_list == c)]
      if(!empty(findWord)) {
        cntVal <- DT[DT$name==findWord$name_list]$cnt
        if(identical(cntVal, numeric(0))) {
          addDT <- data.table(name=findWord$name_list, cnt=1)
          DT <- rbind(DT, addDT)
          print(DT)
        } else {
          DT[DT$name==findWord$name_list]$cnt = cntVal+1  
        }
      }
    }) 
  }
  return(DT)
}

tempDT <- naming.table(commentData$message[23], schoolTable)


