# -*- coding: utf-8 -*- 

import Preprocessing
import Make_model


file_name = ['Article_경제','Article_사회','Article_생활문화','Article_세계','Article_정치','Article_IT과학']

for name in file_name:
    Preprocessing.file_to_ids(name)
    Preprocessing.save(name, './data_after_preprocessing_data', name)
print("형태소 분석완료!")

Preprocessing.combine()

Make_model.Model()