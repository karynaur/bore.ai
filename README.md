# bore.ai

Bored? Feel like talking to someone? You are one click away from chatting in real-time with a virtual AI human.
This virtual human is randomized and can express emotions with lip-synced speech and custom replies coming from a State of the Art Language model. It can understand text, learn its features and give custom replies with very high accuracy. We have also thought of including facial expressions recognition which will make expression-based replies of the virtual human.

## Tech Stack
The app was built using android studio in kotlin, which in turn talks to a python script that is hosted on GCP's Linux VM, which interacts with 3 highly optimized State of the Art Vision and Natural Language Models. 

## Workflow:

-> The app starts off by fetching the picture of a random person (who does not exist) from [thispersondoesnotexist.com](https://thispersondoesnotexist.com), which is then sent to a deep fake model to get a video of the person(?) making random facial expressions until there is no voice input from the user.

-> On hitting the mic button, the voice is recorded and converted to text using the inbuilt Google Speech-To-Text on the Android app. The data is instantly sent to the python script hosted on Google Cloud Platform. 
The text is then run through a Transformer Chat-Bot that was trained on [Cornell Movie-Dialogs Corpus](https://www.cs.cornell.edu/~cristian/Cornell_Movie-Dialogs_Corpus.html), a collection of 220k conversational exchanges. The transformer model uses attention to learn the features of the text in these dialogs and is able to generate replies to short text with a very high accuracy.

-> The output of the model is then run through a Text-To-Speech model that converts the text to a .wav file.

-> The .wav file along with the photo of the previously selected image of the non-existent person is then sent to a Wav2lip Model. Wav2Lip is a State of the Art deep learning model for Lip Sync, which takes an image and an audio file and returns a video of the person in the image talking (with a very high accuracy). 

-> The app then detects the presence of the final video and pulls it down from the cloud and shows it in the layout provided.

-> And this process runs in loop till the user wants to interact with the non-existent human. Also everytime you start a video call you would get a new person fetched from [thispersondoesnotexist.com](https://thispersondoesnotexist.com)

## Acknoledgements
1. [Wav2Lip](https://github.com/Rudrabha/Wav2Lip)
2. [Bryan's Blog](https://medium.com/tensorflow/a-transformer-chatbot-tutorial-with-tensorflow-2-0-88bf59e66fe2)

