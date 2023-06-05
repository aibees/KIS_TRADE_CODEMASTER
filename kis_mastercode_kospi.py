'''코스피주식종목코드(kospi_code.mst) 정제 파이썬 파일'''

import urllib.request
import ssl
import zipfile
import os
import pandas as pd

if os.path.exists("kospi_code.mst") :
    os.remove("kospi_code.mst")

if os.path.exists("kospi_code_main.csv") :
    os.remove("kospi_code_main.csv")

if os.path.exists("kospi_code_serv.csv") :
    os.remove("kospi_code_serv.csv")

base_dir = os.getcwd()
print("base_dir => " + base_dir)

serv_field_specs = [2, 1, 4, 4, 4,
                1, 1, 1, 1, 1,
                1, 1, 1, 1, 1,
                1, 1, 1, 1, 1,
                1, 1, 1, 1, 1,
                1, 1, 1, 1, 1,
                1, 9, 5, 5, 1,
                1, 1, 2, 1, 1,
                1, 2, 2, 2, 3,
                1, 3, 12, 12, 8,
                15, 21, 2, 7, 1,
                1, 1, 1, 1, 9,
                9, 9, 5, 9, 8,
                9, 3, 1, 1, 1]

def kospi_master_download(base_dir, verbose=False):
    cwd = os.getcwd()
    if (verbose): print(f"current directory is {cwd}")
    ssl._create_default_https_context = ssl._create_unverified_context

    urllib.request.urlretrieve("https://new.real.download.dws.co.kr/common/master/kospi_code.mst.zip",
                               "kospi_code.zip")

    os.chdir(base_dir)
    if (verbose): print(f"change directory to {base_dir}")
    kospi_zip = zipfile.ZipFile('kospi_code.zip')
    kospi_zip.extractall()

    kospi_zip.close()

    if os.path.exists("kospi_code.zip"):
        os.remove("kospi_code.zip")


def get_kospi_master_dataframe(base_dir):
    file_name = base_dir + "/kospi_code.mst"
    tmp_fil1 = base_dir + "/kospi_code_main.csv"
    tmp_fil2 = base_dir + "/kospi_code_serv.csv"

    wf1 = open(tmp_fil1, mode="w")
    wf2 = open(tmp_fil2, mode="w")

    serv_len_start = -228


    with open(file_name, mode="r", encoding="cp949") as f:
        for row in f:
            rf1 = row[0:len(row) - 228]
            rf1_1 = rf1[0:9].rstrip()
            rf1_2 = rf1[9:21].rstrip()
            rf1_3 = rf1[21:].strip()
            if(len(rf1_1) == 6) : # 기본 주식종목만, 채권 등은 제외
                wf1.write(rf1_1 + ',' + rf1_2 + ',' + rf1_3 + '\n')

                rf2_len = len(row) - 228
                rf2 = ''

                for l in serv_field_specs :
                    piece = row[rf2_len:rf2_len + l]
                    if rf2 == '' :
                        rf2 = rf1_1 + ',' + piece
                    else :
                        rf2 = rf2 + ',' + piece
                    rf2_len = rf2_len + l

                rf2 = rf2 + '\n'
                wf2.write(rf2)

    wf1.close()
    wf2.close()


kospi_master_download(base_dir, True)
df = get_kospi_master_dataframe(base_dir)