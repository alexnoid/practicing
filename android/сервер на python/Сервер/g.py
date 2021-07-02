from telethon import TelegramClient, sync
import sqlite3 as sql
import contextlib
from telethon.sessions import StringSession
from telethon.tl.functions.messages import GetHistoryRequest

api_id = 3070588
api_hash = 'd672e46b2442ba3d680075bed9788121'
number = '+375447022103'
client = TelegramClient(StringSession(), api_id, api_hash)
client.session.save_entities = False

client.connect()
client.send_code_request(number)