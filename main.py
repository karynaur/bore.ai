import chat_bot
from gtts import gTTS
import sys

output=chat_bot.predict(sys.argv[1])
tts=gTTS(output,lang='en', tld='co.uk')
tts.save('assets/audio.wav')

