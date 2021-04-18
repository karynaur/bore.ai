import chat_bot
from gtts import gTTS
import sys
from Wav2Lip import inference

output=chat_bot.predict(sys.argv[1]) 
with open('assets/output.txt','w') as f:
   f.write(output)
tts=gTTS(output,lang='en', tld='co.uk')
tts.save('assets/audio.wav')

inference.main()

