-- 코드를 입력하세요
SELECT 
    a.apnt_no, 
    p.pt_name, 
    p.pt_no, 
    a.mcdp_cd, 
    dr_name, 
    a.apnt_ymd 

from 
    appointment a 
        join patient p 
            on a.pt_no = p.pt_no
            
        join doctor d
            on d.dr_id = a.mddr_id
            
where date_format(a.apnt_ymd, '%Y-%m-%d') = '2022-04-13' and a.mcdp_cd = 'CS' and a.apnt_cncl_yn != 'Y'

order by apnt_ymd