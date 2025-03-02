FROM node:slim

WORKDIR /app

COPY package*.json /app

RUN npm i

RUN npm install -g @angular/cli@latest

COPY . /app 

EXPOSE 80

CMD [ "ng", "serve", "--host", "0.0.0.0", "--poll", "2000", "--port", "80" ]