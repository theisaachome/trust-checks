import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {ScamReport, SearchResultSummary} from './scamReport';


@Injectable(
  {providedIn: 'root'}
)
export  class ReportService{

    getReports(){
      return data;
    }
    search(query:string):Observable<SearchResultSummary | null>{
      const q = query.trim().toLowerCase();
      if(!q) return  of(null);


      var result= data.filter(report =>
        (report.bank_account_number && report.bank_account_number.toLowerCase().includes(q)) ||
        (report.bank_name && report.bank_name.toLowerCase().includes(q)) ||
        (report.scammer_alias && report.scammer_alias.toLowerCase().includes(q)) ||
        (report.phone_number && report.phone_number.toLowerCase().includes(q)) ||
        (report.scam_description && report.scam_description.toLowerCase().includes(q)) ||
        (report.country && report.country.toLowerCase().includes(q))
      );
      return of({query,totalReports:result.length})
      // if(q.includes('scam')){
      //   return of({query,totalReports:data.length});
      // }
      // data.find((q ) => {})
      // return  of(null);
    }
}

const data: ScamReport[] =[
  {
    "id": "1",
    "country": "SG",
    "bank_account_number": "12345678",
    "bank_name": "DBS",
    "scammer_alias": "James Tan",
    "amount_lost": 300,
    "phone_number": "+6587654321",
    "scam_description": "Requested deposit to view room in Bedok, then disappeared.",
    "evidence_urls": ["https://img.example.com/evidence1.jpg"],
    "created_at": "2025-07-26T10:00:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "2",
    "country": "MY",
    "bank_account_number": "1029384756",
    "bank_name": "Maybank",
    "scammer_alias": "Ali Mamat",
    "amount_lost": 500,
    "phone_number": "+60123456789",
    "scam_description": "Claimed to be agent for room rental in KL Sentral. Asked for booking fee.",
    "evidence_urls": ["https://img.example.com/evidence2.jpg"],
    "created_at": "2025-07-25T15:30:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "3",
    "country": "SG",
    "bank_account_number": "87654321",
    "bank_name": "OCBC",
    "scammer_alias": "Rachel Goh",
    "amount_lost": 200,
    "phone_number": "+6598765432",
    "scam_description": "Asked for full month rental upfront to 'secure room'. Then blocked all contacts.",
    "evidence_urls": [],
    "created_at": "2025-07-20T08:45:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "4",
    "country": "MY",
    "bank_account_number": "9876543210",
    "bank_name": "CIMB",
    "scammer_alias": "Wan Ahmad",
    "amount_lost": 100,
    "phone_number": "+60191234567",
    "scam_description": "Pretended to be Airbnb owner, requested payment outside platform.",
    "evidence_urls": ["https://img.example.com/evidence4.jpg"],
    "created_at": "2025-07-15T12:00:00Z",
    "status": "DISPUTED"
  },
  {
    "id": "5",
    "country": "TH",
    "bank_account_number": "55779988",
    "bank_name": "Bangkok Bank",
    "scammer_alias": "Mr. Somchai",
    "amount_lost": 350,
    "phone_number": "+66812345678",
    "scam_description": "Posted fake condo ad in Sukhumvit. Disappeared after deposit.",
    "evidence_urls": ["https://img.example.com/evidence5.jpg"],
    "created_at": "2025-07-22T11:25:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "6",
    "country": "SG",
    "bank_account_number": "11223344",
    "bank_name": "UOB",
    "scammer_alias": "Kelvin Lee",
    "amount_lost": 250,
    "phone_number": "+6581122334",
    "scam_description": "Used Telegram to pretend to be property agent. Took payment then ghosted.",
    "evidence_urls": [],
    "created_at": "2025-07-21T09:00:00Z",
    "status": "REMOVED"
  },
  {
    "id": "7",
    "country": "MY",
    "bank_account_number": "5566778899",
    "bank_name": "RHB",
    "scammer_alias": "Jason Chin",
    "amount_lost": 400,
    "phone_number": "+60176543210",
    "scam_description": "Used Facebook Marketplace ad to scam for fake room rental.",
    "evidence_urls": ["https://img.example.com/evidence7.jpg"],
    "created_at": "2025-07-10T16:45:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "8",
    "country": "SG",
    "bank_account_number": "44556677",
    "bank_name": "DBS",
    "scammer_alias": "Agent K",
    "amount_lost": 180,
    "phone_number": "+6599332211",
    "scam_description": "Claimed to work with a popular property portal. Asked for non-refundable tour fee.",
    "evidence_urls": [],
    "created_at": "2025-07-18T14:00:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "9",
    "country": "MY",
    "bank_account_number": "10101010",
    "bank_name": "Public Bank",
    "scammer_alias": "Nora Aziz",
    "amount_lost": 600,
    "phone_number": "+60141234567",
    "scam_description": "Scammer said they worked for property developer and asked for deposit.",
    "evidence_urls": ["https://img.example.com/evidence9.jpg"],
    "created_at": "2025-07-17T10:10:10Z",
    "status": "DISPUTED"
  },
  {
    "id": "10",
    "country": "SG",
    "bank_account_number": "99887766",
    "bank_name": "POSB",
    "scammer_alias": "Sarah L.",
    "amount_lost": 120,
    "phone_number": "+6588123456",
    "scam_description": "Asked for $120 to secure room tour appointment. No show.",
    "evidence_urls": [],
    "created_at": "2025-07-13T09:45:00Z",
    "status": "ACTIVE"
  },

  // ... 20 more examples continued

  {
    "id": "11",
    "country": "SG",
    "bank_account_number": "22223333",
    "bank_name": "OCBC",
    "scammer_alias": "Andy Yong",
    "amount_lost": 300,
    "phone_number": "+6583445566",
    "scam_description": "Posted on Carousell claiming to offer room near NUS.",
    "evidence_urls": ["https://img.example.com/evidence11.jpg"],
    "created_at": "2025-07-12T08:00:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "12",
    "country": "MY",
    "bank_account_number": "66778899",
    "bank_name": "Hong Leong Bank",
    "scammer_alias": "Azman Iskandar",
    "amount_lost": 150,
    "phone_number": "+60122334455",
    "scam_description": "Telegram scammer asked for reservation fee for unavailable unit.",
    "evidence_urls": [],
    "created_at": "2025-07-11T13:30:00Z",
    "status": "REMOVED"
  },
  {
    "id": "13",
    "country": "TH",
    "bank_account_number": "33112244",
    "bank_name": "SCB",
    "scammer_alias": "Ploy N.",
    "amount_lost": 280,
    "phone_number": "+66823456789",
    "scam_description": "Instagram room tour scam targeting foreigners in Chiang Mai.",
    "evidence_urls": ["https://img.example.com/evidence13.jpg"],
    "created_at": "2025-07-19T17:20:00Z",
    "status": "ACTIVE"
  },
  {
    "id": "14",
    "country": "SG",
    "bank_account_number": "12344321",
    "bank_name": "DBS",
    "scammer_alias": "Lim Pei",
    "amount_lost": 220,
    "phone_number": "+6599887766",
    "scam_description": "Pretended to be homeowner, gave fake keys after payment.",
    "evidence_urls": ["https://img.example.com/evidence14.jpg"],
    "created_at": "2025-07-08T10:15:00Z",
    "status": "ACTIVE"
  },

  // ... You can repeat with various aliases, countries, phone numbers, and bank names
  // I can continue generating all 30 if you want them in a downloadable file or full array.
  // Just say "continue" or "give me a file".
];
