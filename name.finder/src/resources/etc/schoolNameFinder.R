sessionInfo()

install.packages("KoNLP")
install.packages("plyr")
library(KoNLP)
library(plyr)

#세종사전사용 
useSejongDic()

#Test
strLine <- '"동탄 석우중학교에 저희학교는 매번 3분자장면같은 자장면줘서 무슨 다시다폭탄맞는 느낌이에요 이런 느낌안나는 맛있는 자장면먹고싶어요 왜냐면 자장면은 맛있거든요 그래서 맛있는거 먹고싶어요 여기서 주는 자장면요"'
schoolList <- read.delim("all_school_name.txt", fileEncoding = "UTF-8", sep="\t")

#학교명사전 추가
mergeUserDic(schoolList)
extractNoun(strLine)
MorphAnalyzer(strLine)
SimplePos22(strLine)

#comment 목록취득(workspace에 csv파일 복사해놓을것 )
csvFile <- readLines("comments.csv", encoding = "UTF-8")
zz <- textConnection(csvFile)
commentData <- read.csv(zz,header=F,quote="\"") # give text input
close(zz)

commentData[1366,1]

#컬럼명 변경 
names(commentData)[1] <- c("message")

commentData$message[1:5]
naming.score = function(sentences, name_list) {
  scores = lapply(sentences, function(line, name_list) {
    extractNoun(as.character(line))
  })
  return(scores)
  #scores.df = data.frame(score=scores, text=sentences)
}
temp <- naming.score(commentData$message[1:2], schoolList)


