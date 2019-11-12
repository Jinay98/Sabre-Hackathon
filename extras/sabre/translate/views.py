from django.http import JsonResponse
from googletrans import Translator
from urllib.parse import unquote


def index(request, text, src):
    translator = Translator()
    text = unquote(text)
    translated = translator.translate(text, dest=src)
    data = {
        'translation': translated.text
        ,
    }
    return JsonResponse(data)
