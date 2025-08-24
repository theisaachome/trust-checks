export interface CaseReport {
  report_id: string; // UUID
  reported_at: string; // ISO datetime
  scammer_details: ScammerDetails;
  reporter: Reporter;
  modality: string;
  tags: string[];
  data_source: string;
  notes?: string;
  declarationConsent: boolean;
}

export interface ScammerDetails {
  scammer_alias: string;
  full_name: string;
  phone_number: string;
  email_address?: string;
  scam_case_information: ScamCaseInformation;
  payment_information?: PaymentInformation;
  case_evidence?: CaseEvidence;
  social_media_handles?: SocialMediaHandle[];
  location?: Location;
}

export interface ScamCaseInformation {
  scam_category: string;
  case_type: string;
  date_of_incident: string; // ISO date
  short_story: string;
  long_story?: string;
}

export interface PaymentInformation {
  total_amount_lost: number;
  currency: string;
  transactions: Transaction[];
}

export interface Transaction {
  payment_method: string;
  bank_name?: string;
  bank_account_number?: string;
  account_holder_name?: string;
  amount: number;
  transaction_date: string; // ISO date
}

export interface CaseEvidence {
  attachments: EvidenceFile[];
  link?: string;
}

export interface EvidenceFile {
  file_name: string;
  file_url: string;
  file_type: string;
}

export interface SocialMediaHandle {
  platform: string;
  profile_url: string;
}

export interface Location {
  country_name: string;
  country_code: string;
  city_name?: string;
}

export interface Reporter {
  reporter_id: string; // UUID
  nick_name: string;
  contact_email?: string;
  contact_phone?: string;
}
