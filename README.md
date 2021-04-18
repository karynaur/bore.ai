# video-call-a-person-who-doesnt-exist
Blahhh
## Inspiration
Lockdown has been hard on our fellow hackers and we wanted to make sure that they kept themselves engaged during these hard times. We present to you **bore.ai**. A sophisticated mobile app that lets you talk in real-time to a human that does not exist! 

## What it does
Bored? Feel like talking to someone? You are one click away from chatting in real-time with a virtual AI human.
This virtual human is randomized and can express emotions with lip-synced speech and custom replies coming from a State of the Art Language model. It can understand text, learn its features and give custom replies with very high accuracy. We have also thought of including facial expressions recognition which will make expression-based replies of the virtual human.

## How we built it
The app was built using android studio in kotlin, which in turn talks to a python script that is hosted on GCP's Linux VM, which interacts with 3 highly optimized State of the Art Vision and Natural Language Models. 

## Workflow:
**Clarification : **For testing purposes, we have added only one image, but the actual model can fetch a totally random image(or even generate a random image, but to decrease the processing for better speeds we decided to fetch the image) and generate the desired output given below.

-> The app starts off by fetching the picture of a random person (who does not exist) from [thispersondoesnotexist.com](https://thispersondoesnotexist.com), which is then sent to a deep fake model to get a video of the person(?) making random facial expressions until there is no voice input from the user.

-> On hitting the mic button, the voice is recorded and converted to text using the inbuilt Google Speech-To-Text on the Android app. The data is instantly sent to the python script hosted on Google Cloud Platform. 
The text is then run through a Transformer Chat-Bot that was trained on [Cornell Movie-Dialogs Corpus](https://www.cs.cornell.edu/~cristian/Cornell_Movie-Dialogs_Corpus.html), a collection of 220k conversational exchanges. The transformer model uses attention to learn the features of the text in these dialogs and is able to generate replies to short text with a very high accuracy.

-> The output of the model is then run through a Text-To-Speech model that converts the text to a .wav file.

-> The .wav file along with the photo of the previously selected image of the non-existent person is then sent to a Wav2lip Model. Wav2Lip is a State of the Art deep learning model for Lip Sync, which takes an image and an audio file and returns a video of the person in the image talking (with a very high accuracy). 

-> The app then detects the presence of the final video and pulls it down from the cloud and shows it in the layout provided.

-> And this process runs in loop till the user wants to interact with the non-existent human. Also everytime you start a video call you would get a new person fetched from [thispersondoesnotexist.com](https://thispersondoesnotexist.com)

## Challenges we ran into
Understanding how the models work was a huge challenge. We overfit the model initially which led to inaccurate responses from the chatbot. We had to learn how GCP works from scratch. With less than a week's experience in android app development and literally using GCP for the first time, it was very difficult to learn everything and implement it. We were successfully able to finish off the tasks one-by-one until we had to host the python script. We installed an Ubuntu VM on the GCP, and running the main script everytime gave new errors and we fixed them one-by-one which took like 4-5 hours. After all that the script was running on the VM successfully but we had to call it remotely and download the results which is where we got stuck as we had zero experience in it.
Also we could not make a long video as we were trying to somehow integrate to GCP and get the app working, but this description is very much self explanatory and we have covered everything in the description.

## Accomplishments that we're proud of
A **completely** working end-to-end real-time model that takes in input in the form of text(converted from speech on the app) and generates a reply to that text, converts to audio, syncs the audio with the photo and saves it as a video to be instantly downloaded and displayed in the app
speech and input from the device and returns a video of the non-existent person taking back to you. 
Made a working front end android app for the idea, which has Speech-To-Text mic button, displays your input as text on the screen. As we couldn't totally integrate everything together, we have made the layouts for live front camera feed for facial expression recognition and made layout for the live video of the virtual human which the user will talk to.

## What we learned
We learned how to leverage the transformer architecture to make a chatbot. We had the opportunity to learn how android studio works and make an end-to-end android application. We also got introduced to GCP and how to run/stop/SSH into instances.

## What's next for bore.ai
Host the model on a GPU instance in GCP which will reduce the lag by a huge margin. Work more on our python skills and try to make a more optimized algorithm that is more efficient. Removing the mic button completely, and implement Realtime voice recognition and then responses based on that. After that we don't think there will be anything left to add.
