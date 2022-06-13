import numpy as np
import matplotlib.pyplot as plt
import cv2
import tensorflow as tf
from flask import Flask, request, jsonify

model = tf.keras.models.load_model('model.h5')


def get_img(imgpath):
    img = plt.imread(imgpath)
    img = cv2.resize(img, (256, 256))

    return img


def predict(x):
    img = np.array(x)
    predictions = model.predict(img)

    return predictions


# Get Clothes Object
def get_clothes(actual, mask, min_color, max_color):
    masking = cv2.inRange(mask, min_color, max_color)
    result = cv2.bitwise_and(actual, actual, mask=masking)

    return result


app = Flask(__name__)


@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        file = request.files.get('file')
        if file is None or file.filename == "":
            return jsonify({"error": "no file"})

        try:
            pass
        except Exception as e:
            return jsonify({"error": str(e)})

    return "OK"


if __name__ == "__main__":
    app.run(debug=True)
