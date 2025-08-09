


export interface SearchResultSummary{
  query:string;
  totalReports:number;
}

export interface ScamReport {
  id: string;
  country: string;
  bank_account_number: string;
  bank_name?: string;
  scammer_alias?: string;
  amount_lost?: number;
  phone_number?: string;
  scam_description?: string;
  evidence_urls: string[];
  created_at: string;
  status: 'ACTIVE' | 'DISPUTED' | 'REMOVED';
}
