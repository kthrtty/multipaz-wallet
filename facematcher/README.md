# Face Matcher Model

This directory contains the machine learning model used for biometric face
matching during credential presentment.

## Model Provenance

The model file `mobile_facenet.tflite` is Qualcomm's official pre-exported
MobileFaceNet model obtained from the Qualcomm AI Hub:

* **Architecture:** MobileFaceNet (Chen et al., 2018, "MobileFaceNets:
  Efficient CNNs for Accurate Real-Time Face Verification on Mobile Devices")
* **Provider:** Qualcomm Technologies, Inc.
  ([Qualcomm AI Hub](https://aihub.qualcomm.com/))
* **Model Card:**
  [Hugging Face: qualcomm/MobileFaceNet](https://huggingface.co/qualcomm/MobileFaceNet)
* **Source Archive:**
  [Qualcomm AI Hub release v0.62.2](https://qaihub-public-assets.s3.us-west-2.amazonaws.com/qai-hub-models/models/mobile_facenet/releases/v0.62.2/mobile_facenet-tflite-float.zip)
* **License:** Apache License 2.0 (Apache-2.0)
* **Precision:** Float32
* **Tensors:**
  * Input: 2 inputs (`img1`, `img2`), each `[1, 3, 112, 112]` float32
    normalized to `[0.0, 1.0]`
  * Output: 1 output (`embeddings`), shape `[2, 128]` float32

## Intended Use & Security Notice

This model is intended solely for development, testing, and demonstration
purposes. It does not provide biometric security guarantees or presentation
attack detection (anti-spoofing).
